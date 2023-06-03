onload = () => {
  $('#headerUsername').text($util.getItem('userInfo').username)
  $('#headerDivB').text('创建用户')

  $('#startTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd hh:mm:ss', // 显示格式
    // minView: "month", // 设置只显示到月份
    minView: 0,  //0表示可以选择小时、分钟   1只可以选择小时
    minuteStep: 1,//分钟间隔1分钟
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })
  $('#endTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd hh:mm:ss', // 显示格式
    // minView: "month", // 设置只显示到月份
    minView: 0,  //0表示可以选择小时、分钟   1只可以选择小时
    minuteStep: 1,//分钟间隔1分钟
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })

  let user = $util.getPageParam('user')
  if (user) {
    $('#username').val(user.username)
    $('#password').val(user.password)
    $('#startDate').val(user.startTime)
    $('#endDate').val(user.stopTime)
  }
}


const handleCreateUser = () => {
  let params = {
    username: $('#username').val(),
    password: $('#password').val(),
    startTime: $('#startDate').val() && new Date($('#startDate').val()).getTime(),
    stopTime: $('#endDate').val() && new Date($('#endDate').val()).getTime(),
    status:1
  }
  if (!params.username) return alert('账号不能为空！')
  if (!params.password) return alert('密码不能为空！')
  if (!params.startTime) return alert('开始时间不能为空！')
  if (!params.stopTime) return alert('结束时间不能为空！')
  $.ajax({
    url: API_BASE_URL + '/admin/addUserinfo',
    type: 'POST',
    data: JSON.stringify(params),
    dataType: 'json',
    contentType: 'application/json',
    success(res) {
      if (res.code === "666") {
        location.href = '/pages/user/index.html'
      } else {
        alert(res.message)
      }
    }
  })
}
