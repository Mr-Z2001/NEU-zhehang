const metainfo = {}

onload = () => {
  const url = location.href;
  const url_split_arr = url.split('?');
  if (url_split_arr.length < 2) {
    return alert(undefined);
  }

  const param_pair = url_split_arr[1].split('&');
  const params = {};
  for (pairkey in param_pair) {
    const kv = param_pair[pairkey].split('=');
    params[kv[0]] = kv[1];
  }
  console.log(params);
  metainfo.formId = params.id;

  $.ajax({
    url: API_BASE_URL + '/selectFormInfo',
    type: 'POST',
    data: JSON.stringify(params),
    dataType: 'json',
    contentType: 'application/json',
    success(res) {
      if (res.code === '666') {
        console.log(res.data);
        metainfo.projectId = res.data.projectId;
        metainfo.createdBy = $util.getItem('userInfo').username

        const question_info = JSON.parse(res.data.formContent);
        console.log(question_info);

        $('#questionnaire-title').html = question_info.Title;
        $('#questionnaire-description').html = question_info.Description;

        addproblems(question_info.Problem)
      } else {
        alert(res.message)
      }
    }
  })
}

const addproblems = (problemlist) => {
  for (let idx = 0; idx < problemlist.length; ++idx) {
    const problemx = 'prob-' + idx;

    switch (problemlist[idx].problemType) {
      case 1:
        renderSingleChoice(idx + 1, problemx, problemlist[idx])
        break;
      case 2:
        renderMultipleChoice(idx + 1, problemx, problemlist[idx])
        break;
      case 3:
        renderFillBlanks(idx + 1, problemx, problemlist[idx])
        break;
      case 4:
        renderMatrix(idx + 1, problemx, problemlist[idx])
        break;
      case 5:
        renderGauge(idx + 1, problemx, problemlist[idx])
        break;
      default:
        console.log(problemlist[idx]);
    }
  }
}


/**
 * 
 * @param {number} idx 
 * @param {string} pid 
 * @param {object} pobj 
 */
const renderSingleChoice = (idx, pid, pobj) => {
  $('#problem').append(`
  <div class="question" id="${pid}" data-type="1" data-problemIndex="${idx - 1}">
    <div class="top">
      <span class="question-title" id="questionTitle">${idx}. ${pobj.problemName}</span>
      <span class="must-answer" id="mustAnswer">必答题</span>
    </div>
    <div class="bottom">
    </div>
  </div>
  `);
  for (let i = 0; i < pobj.option.length; ++i) {
    $('#' + pid + ' > ' + '.bottom').append(`
    <div style="display: flex; align-items: center; margin-bottom: 3px;">
      <label class="radio-inline">
        <input type="radio" name="${pid}" value='${i}'>${pobj.option[i].chooseTerm}
      </label>
    </div>
    `)
  }
}

/**
 * 
 * @param {number} idx 
 * @param {string} pid 
 * @param {object} pobj 
 */
const renderMultipleChoice = (idx, pid, pobj) => {
  $('#problem').append(`
  <div class="question" id="${pid}" data-type="2" data-problemIndex="${idx - 1}">
    <div class="top">
      <span class="question-title" id="questionTitle">${idx}. ${pobj.problemName}</span>
      <span class="must-answer" id="mustAnswer">必答题</span>
    </div>
    <div class="bottom">
    </div>
  </div>
  `);
  for (let i = 0; i < pobj.option.length; ++i) {
    $('#' + pid + ' > ' + '.bottom').append(`
    <div style="display: flex; align-items: center; margin-bottom: 3px;">
      <label class="checkbox-inline">
        <input type="checkbox" name="${pid}" value='${i}'>${pobj.option[i].chooseTerm}
      </label>
    </div>
    `);
  }
}


/**
 * 
 * @param {number} idx 
 * @param {string} pid 
 * @param {object} pobj 
 */
const renderFillBlanks = (idx, pid, pobj) => {
  $('#problem').append(`
    <div class="question" id="${pid}" data-type="3" data-problemIndex="${idx - 1}">
      <div class="top">
        <span class="question-title" id="questionTitle">${idx}. ${pobj.problemName}</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom">
        <textarea class="form-control" name="${pid}" placeholder="请输入" rows="4" style="width: 70%;"></textarea>
    </div>
  `)
}

/**
 * 
 * @param {number} idx 
 * @param {string} pid 
 * @param {object} pobj 
 */
const renderMatrix = (idx, pid, pobj) => {
  $('#problem').append(`
  <div class="question" id="question1" data-type="1" data-problemIndex="1">
    <div class="top">
      <span class="question-title" id="questionTitle">4.矩阵题</span>
      <span class="must-answer" id="mustAnswer">必答题</span>
    </div>
    <div class="bottom">
      <table class="table">
        <thead>
          <tr>
            <th></th>
            <th>选项1</th>
            <th>选项2</th>
            <th>选项3</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>标题1</td>
            <td><input type="radio" name="chooseTerm1" /></td>
            <td><input type="radio" name="chooseTerm1" /></td>
            <td><input type="radio" name="chooseTerm1" /></td>
          </tr>
          <tr>
            <td>标题2</td>
            <td><input type="radio" name="chooseTerm2" /></td>
            <td><input type="radio" name="chooseTerm2" /></td>
            <td><input type="radio" name="chooseTerm2" /></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
`)
}

/**
 * 
 * @param {number} idx 
 * @param {string} pid 
 * @param {object} pobj 
 */
const renderGauge = (idx, pid, pobj) => {
  $('#problem').append(`
  <div class="question" id="question1" data-type="1" data-problemIndex="1">
    <div class="top">
      <span class="question-title" id="questionTitle">5.量表题</span>
      <span class="must-answer" id="mustAnswer">必答题</span>
    </div>
    <div class="bottom" style="display: flex; align-items: center; justify-content: space-between;">
      <div>很满意</div>
      <div>
        <label class="radio-inline">
          <input type="radio" name="fraction" />5
        </label>
      </div>
      <div>
        <label class="radio-inline">
          <input type="radio" name="fraction" />4
        </label>
      </div>
      <div>
        <label class="radio-inline">
          <input type="radio" name="fraction" />3
        </label>
      </div>
      <div>
        <label class="radio-inline">
          <input type="radio" name="fraction" />2
        </label>
      </div>
      <div>
        <label class="radio-inline">
          <input type="radio" name="fraction" />1
        </label>
      </div>
      <div>很不满意</div>
    </div>
  </div>
`)
}

/**
 * 
 * @param {string} fmt 
 */
const formatDate = (fmt) => {
  const date = new Date;
  var o = {
    "M+": date.getMonth() + 1,
    "d+": date.getDate(),
    "H+": date.getHours(),
    "m+": date.getMinutes(),
    "s+": date.getSeconds(),
    "q+": Math.floor((date.getMonth() + 3) / 3),
    "S": date.getMilliseconds()
  };

  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substring(4 - RegExp.$1.length));
  }

  for (k in o) {
    if (new RegExp("(" + k + ")").test(fmt)) {
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substring(("" + o[k]).length)));
    }
  }

  return fmt;
}

const subans = () => {
  const prob = document.querySelector('form');
  const data = new FormData(prob)
  let output = {};
  for (const entry of data) {
    if (output[entry[0]] === undefined) {
      output[entry[0]] = new Array();
    }
    output[entry[0]].push(entry[1]);
    console.log(entry);
  }

  const date = new Date();

  metainfo.ansContent = JSON.stringify(output);
  metainfo.creationDate = date.getTime() // formatDate("yyyy-MM-dd HH:mm:ss");

  console.log(metainfo);

  $.ajax({
    url: API_BASE_URL + '/addAnsInfo',
    type: "POST",
    data: JSON.stringify(metainfo),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      console.log(res);
      alert("提交成功");
    }
  })
}