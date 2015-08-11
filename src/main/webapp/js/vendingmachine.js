var userResponse = "";
var moneyStatus = "";
var glbItem = null;
var glbItemArray = [true, true, true, true, true, true, true, true, true, true, true, true];
var glbItemInventoryArray = [];
var glbItemRetrieved = false;

$(document).ready(function () {
    loadItems();
    $("#userResponse1").css({padding: "16px"});
    $("#userResponse2").css({padding: "16px"});
    $("#enterMoney").click(function (event) {

        $.ajax({url: 'money/' + $("#userMoney").val() * 100}).success(function (data, status) {
            $("#userMessage").text(data);
        });
    });
    $("#vend").click(function (event) {

        if (glbItem != null) {
            var itemId = glbItem.parent().attr('id');
            if (glbItemInventoryArray[itemId] > 0) {
                $.ajax({url: 'response/' + itemId}).success(function (data, status) {
                    var itemId = glbItem.parent().attr('id');
                    $("#userMoney").val(data);

                    if (0 <= itemId && itemId <= 3) {
                        drop = "105%";
                    }
                    else if (4 <= itemId && itemId <= 7) {
                        drop = "72%";
                    }
                    else {
                        drop = "43%";
                    }

                    itemNumber = itemId;
                    if (glbItemInventoryArray[itemId] > 0) {

                        if (glbItemArray[itemId] == true) {
                            glbItem.animate({top: "+=" + drop}, 500);
                            glbItemArray[itemId] = false;
                            $.ajax({url: 'item/' + itemId});//.success(function (data, status){})
                            glbItemInventoryArray[itemId]--;
                            $("#userMessage").text("Please retrieve your item.");
                        } else {
                            var itemId = glbItem.parent().attr('id');
                            if (glbItemArray[itemId] == false) {
                                glbItem.animate({top: "-=" + drop}, 5);
                                glbItemArray[itemId] = true;
                            }
                            glbItem = null;
                            $("#userMessage").text("");

                        }
                        userResponse = "";
                    }
                });
            }
        } else {
            $("#userMessage").text("Please select an item to vend.");
        }

    });
    $("#exit").click(function (event) {
        userResponse = "";
        var change = $("#userMoney").val() * 100;
        var pennies = 0;
        var nickels = 0;
        var dimes = 0;
        var quarters = 0;

        while (change != 0) {
            if (change >= 25) {
                change -= 25;
                quarters += 1;
            } else if (change >= 10) {
                change -= 10;
                dimes += 1;
            } else if (change >= 5) {
                change -= 5;
                nickels += 1;
            } else {
                change -= 1;
                pennies += 1;
            }
        }
        $("#quarters").text(quarters);
        $("#dimes").text(dimes);
        $("#nickels").text(nickels);
        $("#pennies").text(pennies);

        $("#userMoney").val(0);
        $.ajax({url: 'response/exit'}).success(function (data, status) {
        
        });
    });
});



function loadItems() {

    var itemTable = $('#items');
    var rowCount = 0; // number of items in current row (maximum of 4)
    var rowIndex = 0;
    var numberRows = 0; // number of complete rows
    var tableFilled = false;
    $.ajax({
        url: 'items'
    }).success(function (data, status) {

        // start table

        $.each(data, function (index, item) {
            glbItemInventoryArray[index] = item.inventory;
            if (item.inventory == 0)
                $("#" + index).fadeTo(100, 0.4);
            $("#cost" + index).text(item.cost.toFixed(2));
        });

    });
}


function itemSelected(itemID) {
    var item = $("#" + itemID);
    glbItem = item;
    var itemId = item.parent().attr('id');
    var cost = $("#cost" + itemID);
    var drop = 0;

    selectionId = itemId;
    if (glbItemArray[itemId] == true) {
        $.ajax({url: 'item/' + itemId}).success(function (data, status) {
            moneyStatus = data;
            if (data === "enough") {
                if ((glbItemInventoryArray[itemId]) == 0)
                    $("#userMessage").text("This item is out of stock");
                else
                    $("#userMessage").text("Would you like to vend the selected item or exit this session?");
            }
            else {
                if ($("#userMoney").val() === "") {
                    $("#userMessage").text("Please enter money into the machine");
                } else {
                    $("#userMessage").text("The item selected costs more than " + $("#userMoney").val());
                }
            }
        });

    } else {
        var itemId = glbItem.parent().attr('id');
        if (0 <= itemId && itemId <= 3) {
            drop = "105%";
        }
        else if (4 <= itemId && itemId <= 7) {
            drop = "72%";
        }
        else {
            drop = "43%";
        }


        if (glbItemArray[itemId] == false) {
            glbItem.animate({top: "-=" + drop}, 5);
            glbItemArray[itemId] = true;
            if ((glbItemInventoryArray[itemId]) == 0) {
                $("#" + itemId).fadeTo(100, 0.4);
            }
        }
        glbItem = null;
        $("#userMessage").text("");

    }



}

/*function reloadItem(itemObj) {
 
 var itemTable = $('#items');
 var rowCount = 0; // number of items in current row (maximum of 4)
 var rowIndex = 0;
 var numberRows = 0; // number of complete rows
 var tableFilled = false;
 
 
 // start table
 var itemId = itemObj.selector.toString()[4];
 var item = $("#" + itemId);
 var imgDiv = $("#img" + item[0].itemId);
 var costDiv = $("#cost" + item[0].itemId);
 
 if (item.inventory == 0) {
 item.fadeTo(100, 0.4);
 }
 
 imgDiv.html("<p> isakfsdafsa</p>");
 //costDiv.append(item.cost.toFixed(2));
 
 }*/

function getItem() {
    var itemId = glbItem.parent().attr('id');
    if (glbItemArray[itemId] == false) {
        glbItem.animate({top: "-=" + drop}, 5);
        glbItemArray[itemId] = true;
    }
    glbItem = null;
    $("#userMessage").text("");

}