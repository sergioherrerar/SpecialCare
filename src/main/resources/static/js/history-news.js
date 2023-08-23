// Call the dataTables jQuery plugin
$(document).ready(function () {
  load();
  loadPets();
  loadVeterinarians();
  loadNewTypes();
  $("#table").DataTable();
});

async function load() {
  const request = await fetch("api/history-news", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });

  const historyNews = await request.json();

  var html = "";
  for (var history of historyNews) {
    var getButton =
      '<a href="#" onclick="getRecord(' +
      history.id +
      ')" class="btn btn-primary btn-circle btn-sm mx-1"><i class="fas fa-eye"></i></a>';

    var updateButton =
      '<a href="#" onclick="updateRecord(' +
      history.id +
      ')" class="btn btn-warning btn-circle btn-sm mx-1"><i class="fas fa-pencil-alt"></i></a>';

    var deleteButton =
      '<a href="#" onclick="deleteRecord(' +
      history.id +
      ')" class="btn btn-danger btn-circle btn-sm mx-1"><i class="fas fa-trash"></i></a>';

    var rowHtml =
      "<tr><td>" +
      history.id +
      "</td><td>" +
      history.pet.name +
      "</td><td>" +
      history.veterinarian.fullname +
      "</td><td>" +
      history.newType.name +
      "</td><td>" +
      history.applicationDate +
      "</td><td>" +
      getButton +
      updateButton +
      deleteButton +
      "</td></tr>";
    html += rowHtml;
  }

  document.querySelector("#table tbody").outerHTML = html;
}

async function loadPets() {
  const request = await fetch("api/pets", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });

  const pets = await request.json();

  var html = "";
  for (var pet of pets) {
    var rowHtml = `<option value="${pet.id}">${pet.id} - ${pet.name}</option>`;
    html += rowHtml;
  }

  document.querySelector("#txtPet").innerHTML = html;
}

async function loadVeterinarians() {
  const request = await fetch("api/veterinarians", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });

  const veterinarians = await request.json();

  var html = "";
  for (var veterinarian of veterinarians) {
    var rowHtml = `<option value="${veterinarian.id}">${veterinarian.id} - ${veterinarian.fullname}</option>`;
    html += rowHtml;
  }

  document.querySelector("#txtVeterinarian").innerHTML = html;
}

async function loadNewTypes() {
  const request = await fetch("api/new-types", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });

  const newTypes = await request.json();

  var html = "";
  for (var newType of newTypes) {
    var rowHtml = `<option value="${newType.id}">${newType.id} - ${newType.name}</option>`;
    html += rowHtml;
  }

  document.querySelector("#txtNewType").innerHTML = html;
}

async function deleteRecord(id) {
  if (!confirm(`¿Desea eliminar este registro`)) {
    return;
  }

  function getHeaders() {
    return {
      Accept: "application/json",
      "Content-Type": "application/json",
      Authorization: localStorage.token,
    };
  }

  const request = await fetch("api/history-news/" + id, {
    method: "DELETE",
    headers: getHeaders(),
  });

  location.reload();
}

async function register() {
  var data = {};
  data.petId = document.getElementById("txtPet").value;
  data.veterinarianId = document.getElementById("txtVeterinarian").value;
  data.newTypeId = document.getElementById("txtNewType").value;
  data.applicationDate = document.getElementById("txtApplicationDate").value;
  data.remarks = document.getElementById("txtRemarks").value;

  await fetch("api/history-news", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });

  alert("¡El registro fue creado con éxito!");

  window.location.href = "history-news.html";
}
