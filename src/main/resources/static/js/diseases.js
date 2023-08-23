// Call the dataTables jQuery plugin
$(document).ready(function () {
  load();
  $("#table").DataTable();
});

async function load() {
  const request = await fetch("api/diseases", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });

  const diseases = await request.json();

  var html = "";
  for (var disease of diseases) {
    var getButton =
      '<a href="#" onclick="getRecord(' +
      disease.id +
      ')" class="btn btn-primary btn-circle btn-sm mx-1"><i class="fas fa-eye"></i></a>';

    var updateButton =
      '<a href="#" onclick="updateRecord(' +
      disease.id +
      ')" class="btn btn-warning btn-circle btn-sm mx-1"><i class="fas fa-pencil-alt"></i></a>';

    var deleteButton =
      '<a href="#" onclick="deleteRecord(' +
      disease.id +
      ')" class="btn btn-danger btn-circle btn-sm mx-1"><i class="fas fa-trash"></i></a>';

    var rowHtml =
      "<tr><td>" +
      disease.id +
      "</td><td>" +
      disease.name +
      "</td><td>" +
      (disease.description.length > 40
        ? disease.description.substring(0, 40) + " [...]"
        : disease.description) +
      "</td><td>" +
      (disease.chronicle
        ? '<i class="fas fa-check color-principal"></i>'
        : '<i class="fas fa-minus-circle text-muted"></i>') +
      "</td><td>" +
      (disease.deadly
        ? '<i class="fas fa-check color-principal"></i>'
        : '<i class="fas fa-minus-circle text-muted"></i>') +
      "</td><td>" +
      getButton +
      updateButton +
      deleteButton +
      "</td></tr>";
    html += rowHtml;
  }

  document.querySelector("#table tbody").outerHTML = html;
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

  const request = await fetch("api/diseases/" + id, {
    method: "DELETE",
    headers: getHeaders(),
  });

  location.reload();
}

async function register() {
  var data = {};
  data.name = document.getElementById("txtName").value;
  data.description = document.getElementById("txtDescription").value;
  data.symptomsRemarks = document.getElementById("txtSymptomsRemarks").value;
  data.chronicle = document.getElementById("txtIsChronicle").checked;
  data.deadly = document.getElementById("txtIsDeadly").checked;

  await fetch("api/diseases", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });

  alert("¡El registro fue creado con éxito!");

  window.location.href = "diseases.html";
}
