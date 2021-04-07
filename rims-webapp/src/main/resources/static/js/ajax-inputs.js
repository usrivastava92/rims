$(".ajax-dropdown").change(function () {
    var changeElementId = $(this).attr("id");
    var pickElement = false;
    var nextElementId = null;
    var filterJson = {};
    $(".ajax-dropdown").each(function () {
        if (pickElement) {
            nextElementId = $(this).attr("id");
            return false;
        }
        if ($(this).attr("id") == changeElementId) {
            pickElement = true;
        }
        filterJson[$(this).attr("id")] = $(this).children("option:selected").val();
    });
    if (nextElementId != null) {
        populateDropDown(nextElementId, filterJson);
    } else {
        populateProductRecords(filterJson);
    }
});

$(".ajax-datalist").change(function () {
    var changeElementId = $(this).attr("id");
    var pickElement = false;
    var nextElementId = null;
    var filterJson = {};
    $(".ajax-dropdown").each(function () {
        if (pickElement) {
            nextElementId = $(this).attr("id");
            return false;
        }
        if ($(this).attr("id") == changeElementId) {
            pickElement = true;
        }
        filterJson[$(this).attr("id")] = $(this).children("option:selected").val();
    });
    if (nextElementId != null) {
        populateDropDown(nextElementId, filterJson);
    } else {
        populateProductRecords(filterJson);
    }
});

function populateDropDown(elementId, filterJson) {
    var data = {};
    data["element"] = elementId;
    data["filterJson"] = filterJson;
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/products/populatefilter",
        data: JSON.stringify(data),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            addOptionsToSelect(elementId, data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
        done: function (e) {
            console.log("DONE");
        }
    });
}


function populateDatalist(elementId, filterJson) {
    var data = {};
    data["element"] = elementId;
    data["filterJson"] = filterJson;
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/products/populatefilter",
        data: JSON.stringify(data),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            addOptionsToSelect(elementId, data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
        done: function (e) {
            console.log("DONE");
        }
    });
}

function addOptionsToSelect(elementId, data) {
    $("#" + elementId).html("");
    var option = '';
    for (var i = 0; i < data.length; i++) {
        option += '<option value="' + data[i] + '">' + data[i] + '</option>';
    }
    $("#" + elementId).html(option);
}