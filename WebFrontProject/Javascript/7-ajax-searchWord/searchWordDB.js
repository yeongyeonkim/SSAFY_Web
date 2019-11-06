//ajax요청 작업 내용...

var xhr = null;

function getXHR() {// ajax 통신을 하기 위한 객체(XMLHttpRequest) 생성
	return new XMLHttpRequest();
}
function startMethod() {// ajax 요청

	var word = document.getElementById("word");
	
	if (word.value.length > 0) {//검색어가 최소 한 글자 이상
		var param = "?word=" + word.value;

		xhr = getXHR();
		// alert(xhr)
		xhr.open("get", "searchWordDB.jsp" + param, true);// ajax 요청 준비 param을
		xhr.onreadystatechange = callback;// readyState 값이 바뀔때마다 실행할 callback  함수
		xhr.send(null);// ajax 요청 전송. 서버로 요청하는 방식이 get방식이면 send메소드 파라메터는 null
	} else{
		document.getElementById("popupPart").style.display = "none";
	}
	// word.value = "";
}
function callback() {// callback 함수
	if (xhr.readyState == 4 && xhr.status == 200) {
		var popupPart = document.getElementById("popupPart");
		var result = eval(xhr.responseText);// 문자열 데이터를 객체(배열)로 바꿔줌

		if (result != null) { // 데이터가 있으면
			var msg = "";
			for (var i = 0; i < result.length; i++) {
				msg += result[i] + "<br>";
			}
			popupPart.innerHTML = msg; // div에 내용을 넣음
			popupPart.style.display = "block"; // 눈에 보이게 함
		}

		// 나머지 입력칸들을 value로 값 넣음
	}
}