/**
 * 
 */

function checkUserIdExist(){
		
		var user_id = $("#user_id").val()
		
		if(user_id.length == 0){
			alert('아이디를 입력해주세요')
			return
		}
		
		$.ajax({
			url : '/web_dev_board_project/user/checkUserIdExist/' + user_id,
			type : 'get',
			dataType : 'text',
			success : function(result){
				if(result.trim() == 'true'){
					alert('사용할 수 있는 아이디입니다')
					$("#userIdExist").val('true')
				} else {
					alert('사용할 수 없는 아이디 입니다')
					$("#userIdExist").val('false')
				}
			}
		})
	}
	
	function resetUserIdExist(){
		$("#userIdExist").val('false')
	}