var obj ={};
obj.propl = 3;
console.log(obj);
//////////////////////////////////////////////////////////////////////////
function log(arg){
    console.log(arg);
}
log.myProp = 2;
console.log(log);
console.dir(log);
//////////////////////////////////////////////////////////////////////////
var ar = [3];
ar.myProp = 3;
console.log(ar);
//////////////////////////////////////////////////////////////////////////
var obj = {};
obj.name = 'Joe';
console.log(obj.name);
console.log(obj['name']);

for(var i=0; i<5; i++){
    obj['prop' + i] = i;
}
console.log(obj);
http://www.webtoolkitonline.com/javascript-tester.html