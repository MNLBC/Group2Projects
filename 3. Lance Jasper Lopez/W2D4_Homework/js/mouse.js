document.getElementById('body').onclick = function() { 
alert('I was left clicked') 
}

document.getElementById('body').oncontextmenu = function() { 

  alert('I was right clicked!') 
 } 
  function showMouseCoords(event) {
alert("X: " + event.clientX
+ " - Y: " + event.clientY);

}
  document.addEventListener("click", showMouseCoords);
  document.addEventListener("contextmenu", showMouseCoords);