onload = () => {

  // import createQuestionnaire from '../createNewQuestionnaire/index.js'
  $('#headerUsername').text($util.getItem('userInfo')[0].username)
  $('#headerDivB').text('创建问卷')

  let id = $util.getPageParam('createQuestionnaireid')
  let projectName = $util.getPageParam('createQuestionnaireprojectName')
  console.log(id, 'projectId')
  console.log(projectName, 'projectName')

  $('#selectLeo').append("<option value="+id+">"+projectName+"</option>");
  $('#selectLeo').attr('disabled', true);
  $('#selectLeo').val(id);

  // createQuestionnaire(projectId, projectName)
}

const onCreateTemplate = () => {
  $util.setPageParam('questionnaireType', $('#selectLeo1').val())
  location.href = "/pages/createNewQuestionnaire/index.html"
}

const importHistoryQuestionnaire = () => {
  $('#divider').css('display', 'flex')
  $('#templateB').html('')
  $('#templateB').append(`
    <div class="template-item">
      <div class="item-t">
        <img class="img" src="../../static/images/blank_template.png">
        <div>
          <div class="title">测试</div>
          <div>页面测试数据</div>
        </div>
      </div>
      <div class="item-b">
        <button type="button" class="btn btn-default">导 入</button>
      </div>
    </div>
  `)
}

const surveyTypeTemplate = () => {
  $('#divider').css('display', 'flex')
  $('#templateB').html('')
  $('#templateB').append(`
    <div class="template-item">
      <div class="item-t">
        <img class="img" src="../../static/images/blank_template.png">
        <div>
          <div class="title">创建模板</div>
          <div>题库抽题，限时作答，成绩查询，自动阅卷</div>
        </div>
      </div>
      <div class="item-b">
        <button type="button" class="btn btn-default" onclick="createTemplate()">创 建</button>
      </div>
    </div>
    <div class="template-item">
      <div class="item-t">
        <img class="img" src="../../static/images/blank_template.png">
        <div>
          <div class="title">测试</div>
          <div></div>
        </div>
      </div>
      <div class="item-b">
        <button type="button" class="btn btn-default" onclick="handleEdit()" style="margin-right: 10px;">编 辑</button>
        <button type="button" class="btn btn-default">导 入</button>
      </div>
    </div>
  `)
}

const createTemplate = () => {
  $('#createTemplateModal').modal('show')
}

const handleEdit = () => {
  open('/pages/designQuestionnaire/index.html')
}
