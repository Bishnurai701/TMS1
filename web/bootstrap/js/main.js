const inputs = document.querySelectorAll(".input");

function focusFunc(){
    let parent =this.parentNode.parentNode;
    parent.classlist.add('focus');
}
function blueFunc() {
    let parent =this.parentNode.parentNode;
    if(this.value==""){
        parent.classlist.remove('focus');
    }
}
inputs.forEach(input=>{
    input.addEventListener('focus',focusFunc);
    input.addEventListener('focus',blueFunc);
});