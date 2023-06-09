onload = () => {
  $('#headerUsername').text($util.getItem('userInfo').username)
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
}

handleConfirm = () => {
  let cur = $util.getItem('curform');
  let params = {
    formInfo: $('#surveyDescription').val(),
    formName: $('#surveyName').val(),
    startTime: $('#startTime-text').val(),
    endTime: $('#endTime-text').val(),
    createdBy: $util.getItem('userInfo').username,
    projectId: cur.projectId,
    formType: cur.formType
  }

  if (!params.createdBy) return alert('账号不能为空！')
  if (!params.formName) return alert('问卷名称不能为空！')
  if (!params.startTime) return alert('开始时间不能为空！')
  if (!params.endTime) return alert('结束时间不能为空！')


  $.ajax({
    url: API_BASE_URL + '/addFormInfo',
    type: 'POST',
    data: JSON.stringify(params),
    dataType: 'json',
    contentType: 'application/json',
    success(res) {
      if (res.code === "666") {
        console.log(res.data);
        params.id = res.data;
        $util.setItem('curform', JSON.stringify(params));
        location.href = '/pages/designQuestionnaire/index.html'
      } else {
        alert(res.message)
      }
    }
  })
}