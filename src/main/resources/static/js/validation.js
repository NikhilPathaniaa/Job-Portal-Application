const steps = document.querySelectorAll(".stp");
const circleSteps = document.querySelectorAll(".step");
const formInputs = document.querySelectorAll(".step-1 form input");
const plans = document.querySelectorAll(".plan-card");
const planPrice = document.querySelector(".plan-price");

const names = document.querySelector("#name");
const emails = document.querySelector("#email");
const numbers = document.querySelector("#phone");
const dobs = document.querySelector("#dob");
const pass = document.querySelector("#password");
const copass = document.querySelector("#confirm-password");

const names1 = document.querySelector("#name1");
const emails1 = document.querySelector("#email1");
const numbers1 = document.querySelector("#mobile1");
const dobs1 = document.querySelector("#dob1");
const pass1 = document.querySelector("#pass");
const copass1 = document.querySelector("#conpass");
const role1 = document.querySelector("#role1")

let time;
let currentStep = 1;
let currentCircle = 0;

const obj = {
  plan: null,
  kind: null,
  price: null,
};

steps.forEach((step) => {
  const nextBtn = step.querySelector(".next-stp");
  const prevBtn = step.querySelector(".prev-stp");
  if (prevBtn) {
    prevBtn.addEventListener("click", () => {
      document.querySelector(`.step-${currentStep}`).style.display = "none";
      currentStep--;
      document.querySelector(`.step-${currentStep}`).style.display = "flex";
      circleSteps[currentCircle].classList.remove("active");
      currentCircle--;
    });
  }
  nextBtn.addEventListener("click", () => {
    document.querySelector(`.step-${currentStep}`).style.display = "none";
    if (currentStep < 5 && validateForm()) {
      currentStep++;
      currentCircle++;
    }
    document.querySelector(`.step-${currentStep}`).style.display = "flex";
    circleSteps[currentCircle].classList.add("active");
    summary(obj);
  });
});

function summary(obj) {
  const planName = document.querySelector("b");
  const cool = planName.innerHTML = `${obj.plan.innerText}`;

  names1.value = names.value;
  console.log(names.value);
  console.log(names1.value);
  emails1.value = emails.value;
  numbers1.value=numbers.value
  dobs1.value=dobs.value
  pass1.value=pass.value
  copass1.value=copass.value
  role1.value=cool
}

function validateForm() {
  let valid = true;
  for (let i = 0; i < formInputs.length; i++) {
    if (!formInputs[i].value) {
      valid = false;
      formInputs[i].classList.add("err");
      findLabel(formInputs[i]).nextElementSibling.style.display = "flex"
    } else {
      valid = true;
      formInputs[i].classList.remove("err");
      findLabel(formInputs[i]).nextElementSibling.style.display = "none";
    }
  }
  return valid; 
}

function findLabel(el) {
  const idVal = el.id;
  const labels = document.getElementsByTagName("label");
  for (let i = 0; i < labels.length; i++) {
    if (labels[i].htmlFor == idVal) return labels[i];
  }
}

plans.forEach((plan) => {
  plan.addEventListener("click", () => {
    document.querySelector(".selected").classList.remove("selected");
    plan.classList.add("selected");
    const planName = plan.querySelector("b");
    const planPrice = plan.querySelector(".plan-priced");
    obj.plan = planName;
    obj.price = planPrice;
  });
});
