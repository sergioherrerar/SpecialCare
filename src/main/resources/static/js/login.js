async function login() {
  let data = {};
  data.email = document.getElementById("txtEmail").value;
  data.password = document.getElementById("txtPassword").value;

  const request = await fetch("api/login", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });

  const result = await request.text();
  if (result != "FAIL") {
    localStorage.token = result;
    localStorage.email = data.email;
    window.location.href = "dashboard.html";
  } else {
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }
}
