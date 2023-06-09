let curCharts = []

const loadchart = (formId) => {
    const params = {
        formId: formId
    };

    console.log(formId);

    $.ajax({
        url: API_BASE_URL + '/queryAnsListByFid',
        type: 'POST',
        data: JSON.stringify(params),
        dataType: 'json',
        contentType: 'application/json',
        success(res) {
            if (res.code === '666') {
                console.log(res.data);

                calculate(res.data);
            } else {
                alert(res.message)
            }
        }
    })
}

const calculate = (ansSheets) => {
    let statistics = [];

    for (let idx = 0; idx < ansSheets.length; ++idx) {
        let obj = JSON.parse(ansSheets[idx].ansContent);
        for (k in obj) {
            let tmp = k.substring(5);
            let qidx = parseInt(tmp);
            console.log(tmp, qidx);
            if (isNaN(qidx)) {
                continue;
            }

            if (statistics[qidx] === undefined) {
                statistics[qidx] = []
            }
            for (j of obj[k]) {
                if (isNaN(parseInt(j))) {
                    continue;
                }
                if (statistics[qidx][j] === undefined) {
                    statistics[qidx][j] = 0;
                }
                statistics[qidx][j] += 1;
            }
        }
    }

    console.log(statistics);
    renderChart(statistics);
}

const renderChart = (statistics) => {
    for (let idx = 0; idx < statistics.length; ++idx) {
        let label = [];
        for (let jdx = 0; jdx < statistics[idx].length; ++jdx) {
            if (statistics[idx][jdx] === undefined) {
                statistics[idx][jdx] = 0;
            }
            label.push(jdx);
        }
        $('#modal-body').append(`
            <canvas id="chart-${idx}"></canvas>
        `)
        const ctx = document.getElementById(`chart-${idx}`);

        curCharts.push(
            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: label,
                    datasets: [{
                        label: `Choose of Problem ${idx}`,
                        data: statistics[idx],
                        borderWidth: 1
                    }]
                },
                options: {
                    indexAxis: 'y',
                    scales: {
                        x: {
                            beginAtZero: true
                        }
                    }
                }
            })
        );
    }

  $('#statistics').modal('show')
}

const destroy = () => {
    for (obj of curCharts) {
        obj.destroy();
    }
}