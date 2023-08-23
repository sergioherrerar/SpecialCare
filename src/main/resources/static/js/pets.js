// Call the dataTables jQuery plugin
$(document).ready(function () {
  load();
  loadPetTypes();
  $("#table").DataTable();
});

async function load() {
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
    var getButton =
      '<a href="#" onclick="getRecord(' +
      pet.id +
      ')" class="btn btn-primary btn-circle btn-sm mx-1"><i class="fas fa-eye"></i></a>';

    var updateButton =
      '<a href="#" onclick="updateRecord(' +
      pet.id +
      ')" class="btn btn-warning btn-circle btn-sm mx-1"><i class="fas fa-pencil-alt"></i></a>';

    var deleteButton =
      '<a href="#" onclick="deleteRecord(' +
      pet.id +
      ')" class="btn btn-danger btn-circle btn-sm mx-1"><i class="fas fa-trash"></i></a>';

    var rowHtml =
      "<tr><td>" +
      pet.id +
      "</td><td>" +
      pet.name +
      "</td><td>" +
      pet.petType.name +
      "</td><td>" +
      pet.breed +
      "</td><td>" +
      (pet.gender == "male"
        ? '<i class="fas fa-venus color-principal"></i>'
        : '<i class="fas fa-mars color-principal"></i>') +
      "</td><td>" +
      pet.age +
      "</td><td>" +
      getButton +
      updateButton +
      deleteButton +
      "</td></tr>";
    html += rowHtml;
  }

  document.querySelector("#table tbody").outerHTML = html;
}

async function loadPetTypes() {
  const request = await fetch("api/pet-types", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });

  const petTypes = await request.json();

  var html = "";
  for (var petType of petTypes) {
    var rowHtml = `<option value="${petType.id}">${petType.id} - ${petType.name}</option>`;
    html += rowHtml;
  }

  document.querySelector("#txtPetType").innerHTML = html;
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

  const request = await fetch("api/pets/" + id, {
    method: "DELETE",
    headers: getHeaders(),
  });

  location.reload();
}

async function register() {
  var data = {};
  data.petOwnerId = "7";
  data.name = document.getElementById("txtName").value;
  data.gender = document.getElementById("txtGender").value;
  data.age = document.getElementById("txtAge").value;
  data.petTypeId = document.getElementById("txtPetType").value;
  data.breed = document.getElementById("txtBreed").value;
  data.weight = document.getElementById("txtWeight").value;
  data.height = document.getElementById("txtHeight").value;
  data.foodBrand = document.getElementById("txtFood").value;
  data.birthDate = document.getElementById("txtBirthDate").value;
  data.skinCoatRemarks = document.getElementById("txtSkinCoatRemarks").value;
  data.headRemarks = document.getElementById("txtHeadRemarks").value;
  data.eyesEarsNoseRemarks = document.getElementById(
    "txtEyesEarsNoseRemarks"
  ).value;
  data.additionalRemarks = document.getElementById(
    "textAdditionalRemarks"
  ).value;

  await fetch("api/pets", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });

  alert("¡El registro fue creado con éxito!");

  //window.location.href = "pets.html";
}
