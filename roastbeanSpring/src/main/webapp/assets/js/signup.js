/**
 * 
 */
 
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
 
            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	    }
	}).open();
}

function checkMember(){
	
	var regExpUser_id = /^[a-z0-9]{4,20}$/
	var regExpUser_name = /^[가-힣]{2,10}$/
	var regExpUser_nick = /^[a-z|A-Z|가-힣|0-9]{2,20}$/
	var regExpUser_pw = /^[a-z0-9]{6,20}$/
	var regExpUser_telno = /^\d{3}-\d{3,4}-\d{4}$/
	var regExpUser_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
	
	var form = document.Member
	
	var user_id = form.user_id.value
	var user_name = form.user_name.value
	var user_nick = form.user_nick.value
	var user_pw = form.user_pw.value
	var user_telno = form.user_telno1.value + "-" + form.user_telno2.value + "-" + form.user_telno3.value
	var user_email = form.user_email.value
	
	// ID
	if(form.user_id.value.length == 0) {
	    alert("ID는 필수사항입니다.");
	    form.user_id.focus();
	    return;
	}
	if(!regExpUser_id.test(user_id)){
		alert("ID는 문자와 숫자로 입력해주세요.(4글자 이상, 20글자 이하)")
		form.user_id.select()
		return
	}
	if(form.idDuplication.value != 0){ /**************************/
		alert("ID 중복체크를 해주세요.")
	    form.focus();
		return
	}
	
	// Name
	if(form.user_name.value.length == 0) {
	    alert("이름은 필수사항입니다.");
	    form.focus();
	    return;
	}
	if(!regExpUser_name.test(user_name)){
		alert("이름은 한글만으로 입력해주세요.(2글자 이상, 20글자 이하)")
		form.user_nick.select()
		return
	}

	// Nick
	if(form.user_name.value.length == 0) {
	    alert("닉네임은 필수사항입니다.");
	    form.focus();
	    return;
	}
	if(!regExpUser_name.test(user_name)){
		alert("닉네임은 문자, 한글, 숫자로 입력해주세요.(2글자 이상, 10글자 이하)")
		form.user_name.select()
		return
	}
	if(form.nickDuplication.value != 0){ /**************************/
		alert("닉네임 중복체크를 해주세요.")
	    form.focus();
		return
	}
	
	// Pw
	if(form.user_pw.value.length == 0) {
	    alert("비밀번호는 필수사항입니다.");
	    form.focus();
	    return;
	}
	if(!regExpUser_pw.test(user_pw)){
		alert("비밀번호는 숫자만으로 입력해주세요.(6글자 이상, 20글자 이하)")
		form.user_pw.select()
		return
	}
	if(form.user_pw.value != document.Member.user_pw_check.value) {
	    alert("비밀번호가 일치하지 않습니다. 확인해주세요.");
	    form.focus();
	    return;
	}

	// Telno
	if(!regExpUser_telno.test(user_telno)){
		alert("연락처 입력을 확인해주세요.")
		form.user_telno2.select()
		return
	}

	// Email
	if(form.user_email.value.length == 0) {
	    alert("이메일은 필수사항입니다.");
	    form.focus();
	    return;
	}
	if(!regExpUser_email.test(user_email)){
		alert("이메일 입력을 확인해주세요.")
		form.user_email.select()
		return
	}
	
	if(form.ucertify_num.value.length == 0) {
	    alert("인증번호를 입력해 주세요.");
	    form.ucertify_num.focus();
	    return;
	}
	
	if(form.ucertify_num.value != form.user_certifycheck.value) {
	    alert("인증번호가 틀립니다.");
	    form.ucertify_num.focus();
	    return;
	}
	
	form.submit();
}
	        
