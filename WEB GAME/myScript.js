var circle = null;
var animateh;
var animatev;4
var bar = null;
 function init(){
    circle = document.getElementById('circle');
    circle.style.position= 'relative';
   circle.style.left = '0px';
   bar = document.getElementById("bottom");
   bar.style.left = '0px';
   circle.style.top = '10px';
  
startGame();
}

function moveRight(){
    circle.style.left = parseInt(circle.style.left) + 10 + 'px';
	animateh = setTimeout(moveRight, 100);
		if(getOffset(circle).left > 950){
		clearTimeout(animateh);
		moveLeft();
	}
}
function moveLeft(){
    circle.style.left = parseInt(circle.style.left) - 10 + 'px';
	animateh = setTimeout(moveLeft, 100);
		if(getOffset(circle).left == 0){
		clearTimeout(animateh);
		moveRight();
	}
}
function moveUp(){
	
    circle.style.top = parseInt(circle.style.top) - 10 + 'px';
	animatev = setTimeout(moveUp, 100);
		if(getOffset(circle).top < 0){
		clearTimeout(animatev);
		moveDown();
	}
}
function moveDown(){
	
	
    circle.style.top = parseInt(circle.style.top) + 10 + 'px';
	animateh = setTimeout(moveDown, 100);
		if(getOffset(circle).top > 450){
			checkBlock();
		clearTimeout(animateh);
		moveUp();
	}
}
window.onload =init;


function getOffset(el) {
  el = el.getBoundingClientRect();
  return {
    left: el.left + window.scrollX,
    top: el.top + window.scrollY
  }
}


document.onkeydown = function (e) {
	var code = e.keyCode;
	
	if(code == 39 && parseInt(bar.style.left) < 900){
		
		bar.style.left = parseInt(bar.style.left) + 10 + 'px';
	}
	if(code == 37 && parseInt(bar.style.left) > 0){
		
		bar.style.left = parseInt(bar.style.left) - 10 + 'px';
	}
};
function startGame(){
	moveUp();
	moveRight();
}
function checkBlock(){
	
	if(((parseInt(circle.style.left) - parseInt(bar.style.left)) < 100 )){ 
	}else{
		
		clearTimeout(animateh);
		clearTimeout(animatev);
		bar.style.left = '0px';
   circle.style.top = '10px';
   circle.style.position= 'relative';
   circle.style.left = '10px';
	}
		if(parseInt(circle.style.left) < parseInt(bar.style.left) - 40){
			clearTimeout(animateh);
		clearTimeout(animatev);
		bar.style.left = '0px';
   circle.style.top = '10px';
   circle.style.position= 'relative';
   circle.style.left = '10px';
		}
}
