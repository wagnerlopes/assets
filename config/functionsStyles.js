const greet = function(name) {
  return `Hello, ${name}!`;
};

//console.log(greet('Alice')); // Hello, Alice!

const add = (a, b) => a + b;

//console.log(add(2,3)); // 5

function apply(fn, ...args) {
  return fn(...args);
}
const mul = (x,y) => x*y;

//console.log(apply(mul, 4, 5)); // 20

const makeCounter = () => {
  let count = 0;
  return () => ++count;
};
const c = makeCounter();

//console.log(c()); // 1
//console.log(c()); // 2

const obj = { handler: () => 'ok' };
const arr = [() => 1, () => 2];

//console.log(obj.handler()); // ok
//console.log(arr[1]()); // 2

const fact = function factorial(n) {
  return n <= 1 ? 1 : n * factorial(n-1);
};

//console.log(fact(5)); // 120
