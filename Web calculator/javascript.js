x = localStorage.x;
i = true;
function button0(){
	if(i){
		document.getElementById("header1").innerHTML = "0";
		i = false;
	}else{
		x = document.getElementById("header1").textContent;
		document.getElementById("header1").innerHTML = x + "0";
	}
}
function button1(){
	if(i){
		document.getElementById("header1").innerHTML = "1";
		i = false;
	}else{
		x = document.getElementById("header1").textContent;
		document.getElementById("header1").innerHTML = x+"1";
	}
}
function button2(){
	if(i){
		document.getElementById("header1").innerHTML = "2";
		i = false;
	}else{
		x = document.getElementById("header1").textContent;
		document.getElementById("header1").innerHTML = x+"2";
	}
}
function button3(){
	if(i){
		document.getElementById("header1").innerHTML = "3";
		i = false;
	}else{
		x = document.getElementById("header1").textContent;
		document.getElementById("header1").innerHTML = x+"3";
	}
}
function button4(){
	if(i){
		document.getElementById("header1").innerHTML = "4";
		i = false;
	}else{
		x = document.getElementById("header1").textContent;
		document.getElementById("header1").innerHTML = x+"4";
		}
}
function button5(){
	if(i){
		document.getElementById("header1").innerHTML = "5";
		i = false;
	}else{
		x = document.getElementById("header1").textContent;
		document.getElementById("header1").innerHTML = x+ "5";
	}
}
function button6(){
	if(i){
		document.getElementById("header1").innerHTML = "6";
		i = false;
	}else{
		x = document.getElementById("header1").textContent;
		document.getElementById("header1").innerHTML = x+"6";
	}
}
function button7(){
	if(i){
		document.getElementById("header1").innerHTML = "7";
		i = false;
	}else{
		x = document.getElementById("header1").textContent;
		document.getElementById("header1").innerHTML = x+"7";
	}
}
function button8(){
	if(i){
		document.getElementById("header1").innerHTML = "8";
		i = false;
	}else{
		x = document.getElementById("header1").textContent;
		document.getElementById("header1").innerHTML = x+"8";
	}
}
function button9(){
	if(i){
		document.getElementById("header1").innerHTML = "9";
		i = false;
	}else{
		x = document.getElementById("header1").textContent;
		document.getElementById("header1").innerHTML = x+"9";
	}
}
num1 = 0;
num2 = 0;
symbol = 5;
check = false;
function add(){
		num1 = parseInt(document.getElementById("header1").textContent);
		document.getElementById("header1").innerHTML = "0";
		symbol = 1;
		i = true;
}
function subtract(){
		num1 = parseInt(document.getElementById("header1").textContent);
		document.getElementById("header1").innerHTML = "0";
		symbol = 2;
		i = true;
}
function multiply(){
		num1 = parseInt(document.getElementById("header1").textContent);
		document.getElementById("header1").innerHTML = "0";
		symbol = 3;
		i = true;
}
function divide(){
		num1 = parseInt(document.getElementById("header1").textContent);
		document.getElementById("header1").innerHTML = "0";
		symbol = 4;
		i = true;
}
function clears(){
	i=true;
	symbol = 5;
	document.getElementById("header1").innerHTML = "0";
	num1 = 0;
	num2 = 0;
	localStorage.x = null;
}
function equals(){
	if(symbol == 1){
		num2 = parseInt(document.getElementById("header1").textContent);
		document.getElementById("header1").innerHTML = num1 + num2;
		i = true;
	}
	if(symbol == 2){
		num2 = parseInt(document.getElementById("header1").textContent);
		document.getElementById("header1").innerHTML = num1 - num2;
		i = true;
	}
	if(symbol == 3){
		num2 = parseInt(document.getElementById("header1").textContent);
		document.getElementById("header1").innerHTML = num1 * num2;
		i = true;
		}
	if(symbol == 4){
		num2 = parseInt(document.getElementById("header1").textContent);
		document.getElementById("header1").innerHTML = num1 / num2;
		i = true;
	}else{
	
	}
}
function before(){
	localStorage.x = document.getElementById("header1").textContent;
}
function load(){
	if(localStorage.x != null){
		document.getElementById("header1").innerHTML = (localStorage.x);
		i = false;
	}
	else{
	}
}


























