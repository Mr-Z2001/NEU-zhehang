onload = () => {
  $('#headerUsername').text($util.getItem('userInfo')[0].username)
  $('#headerDivB').text('创建项目')
}

const handleCreateProject = () => {
  let params = {
    createdBy: $util.getItem('userInfo')[0].username,
    lastUpdatedBy: $util.getItem('userInfo')[0].username,
    projectName: $('#projectName').val(),
    projectContent: $('#projectDescribe').val()
  }
  if (!params.projectName) return alert('项目名称不能为空！')
  // return alert if project name is exist
    $.ajax({
      url: API_BASE_URL + '/getProjectInfo',
      type: "POST",
      data: JSON.stringify(params),
      dataType: "json",
      contentType: "application/json",
      success(data) {
        if (data.length > 0) {
          return alert('项目名称已存在！')
        }
      }
    })
  // return alert if project name length > 255
  if (params.projectName.length > 255) return alert('项目名称长度不能超过255！')

  if (!params.projectContent) return alert('项目描述不能为空！')
  $.ajax({
    url: API_BASE_URL + '/addProjectInfo',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success() {
      alert('创建成功！')
      location.href = "/pages/questionnaire/index.html"
    }
  })
}
