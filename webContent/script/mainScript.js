$(document).ready(function(){		//$(function(){
		
	//초기값 설정
	$(".pic").hide();		//숨기기 slideUp(), fadeOut()
	$("#img1").show();		//보이기 slideDown(), fadeIn()
	
	var n=1;
	
	//오른쪽 버튼 클릭시(.nextBtn)
	$(".nextBtn").click(function(){
		n++;
		if(n==1){
			tabMenu1();
		}else if(n==2){
			tabMenu2()
		}else if(n==3){
			tabMenu3();
		}else{
			n=1;
			tabMenu1();
		}
	});
	
	
	//왼쪽 버튼 클릭시(.prevBtn)
	$(".prevBtn").click(function(){
		n--;
		if(n==1){
			tabMenu1();
		}else if(n==2){
			tabMenu2()
		}else if(n==3){
			tabMenu3();
		}else{
			n=3;
			tabMenu3();
		}
	});
	
	
	//tabMenu1~4까지 함수 생성
	function tabMenu1(){
		$(".pic").hide();
		$("#img1").show(500);
		n=1;
	}
	
	function tabMenu2(){
		$(".pic").hide();
		$("#img2").show(500);
		n=2;
	}

	function tabMenu3(){
		$(".pic").hide();
		$("#img3").show(500);
		n=3;
	}
	
});