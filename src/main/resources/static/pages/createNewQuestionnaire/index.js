onload = () => {
  $('#headerUsername').text($util.getItem('userInfo')[0].username)
  $('#headerDivB').text('创建调查问卷')

  $('#startTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd', // 显示格式
    minView: "month", // 设置只显示到月份
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })
  $('#endTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd', // 显示格式
    minView: "month", // 设置只显示到月份
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })

    // let projectId = $util.getPageParam('createQuestionnaireid')
    // console.log(projectId, 'projectId')
    // let projectName = $util.getPageParam('createQuestionnaireprojectName')
    // $('#projectName').text(projectName)
    // console.log(projectName, 'projectName')
    // createQuestionnaire(projectId, projectName)
}

function createQuestionnaire(){
    let params = {
        questionnaireName: $('#surveyName').val(),
        startDate: $('#startDate').val(),
        endDate: $('#endDate').val(),
        creationDate: new Date().getTime(),
        questionnaireDescription: $('#surveyDescription').val(),
        createdBy: $util.getItem('userInfo')[0].username,
        belongToProject: $util.getPageParam('createQuestionnaireid'),
        questionnaireType: $util.getPageParam('questionnaireType')
    }
    $.ajax({
        url: API_BASE_URL + '/addQuestionnaire',
        type: "POST",
        data: JSON.stringify(params),
        dataType: "json",
        contentType: "application/json",
        success(res) {
            if (res.code === 666) {
                alert('创建成功')
                location.href = '/pages/project/index.html'
            } else {
                alert(res.message)
            }
        }
    })
}