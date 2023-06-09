onload = () => {
  $('#headerDivB').text('项目详情')

  let projectId = $util.getPageParam('seeProject')
  console.log(projectId, 'projectId')
  fetchProjectInfo(projectId)
}

const fetchProjectInfo = (id) => {
  let params = {
    id
  }
  $.ajax({
    url: API_BASE_URL + '/selectProjectInfo',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      console.log(res)
      let info = res.data
      console.log(info)
      $('#projectName').text(info.projectName)
      $('#createTime').text(info.creationDate)
      $('#projectDescription').text(info.projectContent)
    }
  })
  
  params = {
    projectId: id
  }

  console.log(JSON.stringify(params))

  $.ajax({
    url: API_BASE_URL + '/queryFormListByPid',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      console.log(res)

      res.data.map(item => {
        $('#forms').append(`
          <tr>
            <td>${0}</td>
            <td>${item.formName}</td>
            <td>${item.startTime} - ${item.endTime}</td>
            <td>
              <button type="button" class="btn btn-link btn-red">发布</button>
              <button type="button" class="btn btn-link btn-red">关闭</button>
              <button type="button" class="btn btn-link btn-red" onclick=copylink("${item.id}")>链接</button>
              <button type="button" class="btn btn-link btn-red">删除</button>
              <button type="button" class="btn btn-link">重置密码</button>
              <button type="button" class="btn btn-link">编辑</button>
              <button type="button" class="btn btn-link" data-toggle="modal" data-target="#statistics" onclick=loadchart("${item.id}")>统计</button>
            </td>
          </tr>
        `)
      })
    }
  })
}

const copylink = (link) => {
  const url = {};
  url.host = location.host;
  url.relloc = '/pages/releaseQuestionnaire/index.html?id=' + link;
  alert(url.host + url.relloc);
}