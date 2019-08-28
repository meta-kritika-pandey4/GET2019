/*
 * It is a method to collapse the Registration Form 
 * when all the fields are correctly filled
 */
function collapseForm1() {
    var result = validateForm();
    if( result ) {
        document.getElementById("Form1").style.display = "none";
        var x = document.getElementById("Form2");
        if ( x.style.display === "none" ) {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
        var employeeId = document.getElementById("Form1").getAttribute("value");
        window.alert("Your registration id is "+employeeId);
        getEmployeeId();
    } else {
        document.getElementById("Form1").style.display = "block";
    }
}

/*
 * It is a method to get the employee id
 * 
 */
function getEmployeeId() {
    var employeeId = document.getElementById("Form1").getAttribute("value");
    document.getElementById("Employee_id").value = employeeId;
}

/*
 * It is a method to collapse the Vehicle Registration Form 
 * when all the fields are correctly filled
 */
function collapseForm2() {
    var validateResult = validateVehicleForm();
    if( validateResult ){
        var valid = true;
        if( document.getElementById("Cycle").checked ) {
            var x = document.getElementById("CyclePass");
            if ( x.style.display === "none" ) {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }
        } else if ( document.getElementById("MotorCycle").checked ) {
            var x = document.getElementById("MotorcyclePass");
            if ( x.style.display === "none") {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            } 
        } else if ( document.getElementById("FourWheelers").checked ) {
            var x= document.getElementById("FourWheelerPass");
            if ( x.style.display === "none") {
                x.style.display = "block";
            } else {
             x.style.display = "none";
            }
        } else {
            document.getElementById("validation_message").innerHTML = "Please select a vehicle type";
            valid = false;
        }
    } else {
        document.getElementById("validation_message").innerHTML = "Please enter the required fields";
    }
    if( valid && validateResult ) {
        document.getElementById("Form2").style.display = "none";
        var x = document.getElementById("choose_currency");
        if ( x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    } else {
        document.getElementById("Form2").style.display = "block";
    }
}  

/*
 * It is a method to get the billing of the
 * cycle pass chosen
 */
function getCyclePassPrice( optionSelected ) {
    var price;
    var valid = true;
    if( document.getElementById("cycle_pass1").checked ) {
        price = document.getElementById("cycle_pass1").value;
    } else if( document.getElementById("cycle_pass2").checked ) {
        price = document.getElementById("cycle_pass2").value;        
    } else if( document.getElementById("cycle_pass3").checked ) {
        price = document.getElementById("cycle_pass3").value;
    } else {
        document.getElementById("vehicle_price_message").innerHTML="Please select a pass type";
        valid = false;
    }
    if( valid ) {
        if( optionSelected === "USD" ) {
            document.getElementById("vehicle_price_message").innerHTML="Your final price is "+(price*0.014)+" "+ optionSelected;
        } else if( optionSelected === "YEN" ) {
            document.getElementById("vehicle_price_message").innerHTML="Your final price is "+(price*1.47)+" "+ optionSelected;
        } else if( optionSelected==="INR" ) {
            document.getElementById("vehicle_price_message").innerHTML="Your final price is "+(price)+" "+ optionSelected;
        }
    }
} 

/*
 * It is a method to get the billing of the
 * motor cycle pass chosen
 */
function getMotorCyclePassPrice( optionSelected ) {
    var price;
    var valid = true;
    if( document.getElementById("motorcycle_pass1").checked ) {
        price = document.getElementById("motorcycle_pass1").value; 
    } else if( document.getElementById("motorcycle_pass2").checked ) {
        price = document.getElementById("motorcycle_pass2").value;
    } else if( document.getElementById("motorcycle_pass3").checked ) {
        price = document.getElementById("motorcycle_pass3").value;           
    } else {
        document.getElementById("vehicle_price_message").innerHTML="Please select a pass type";
        valid = false;
    }
    if ( valid ) {
        if( optionSelected === "USD" ) {
            document.getElementById("vehicle_price_message").innerHTML="Your final price is "+(price*0.014)+" "+ optionSelected;
        } else if( optionSelected==="YEN" ) {
            document.getElementById("vehicle_price_message").innerHTML="Your final price is "+(price*1.47)+" "+ optionSelected;
        } else if( optionSelected === "INR" ) {
            document.getElementById("vehicle_price_message").innerHTML="Your final price is "+(price)+" "+ optionSelected;
        }
    }
}  

/*
 * It is a method to get the billing of the
 * four wheeler pass chosen
 */
function getFourWheelerPassPrice( optionSelected ) {
    var price;
    var valid = true;
    if( document.getElementById("fourwheeler_pass1").checked ) {
        price = document.getElementById("fourwheeler_pass1").value;
    } else if( document.getElementById("fourwheeler_pass2").checked ) {
        price = document.getElementById("fourwheeler_pass2").value;            
    } else if( document.getElementById("fourwheeler_pass3").checked) {
        price = document.getElementById("fourwheeler_pass3").value;
    } else {
        document.getElementById("vehicle_price_message").innerHTML="Please select a pass type";
        valid = false;
    }
    if( valid ) {
        if( optionSelected === "USD" ) {
            document.getElementById("vehicle_price_message").innerHTML="Your final price is "+(price*0.014)+" "+ optionSelected;
        } else if( optionSelected === "YEN" ) {
            document.getElementById("vehicle_price_message").innerHTML="Your final price is "+(price*1.47)+" "+ optionSelected;
        } else if( optionSelected === "INR" ) {
            document.getElementById("vehicle_price_message").innerHTML="Your final price is "+price+" "+ optionSelected;
        }
    } 
}   

/*
 * It is a method to get the currency type chosen
 * by the user
 */
function getCurrency() {
    var currency;
    if( document.getElementById("INR").selected ) {
        currency = document.getElementById("INR").value;
    } else if( document.getElementById("USD").selected ) {
        currency = document.getElementById("USD").value;
    } else if( document.getElementById("YEN").selected ) {
        currency = document.getElementById("YEN").value;
    } else {
        document.getElementById("vehicle_price_message").innerHTML="Please choose a currency type";
    }  
    return currency;
}

/*
 * It is a method to set the currency in the billing table
 *
 */
function changeCurrency() {
    if( document.getElementById("Cycle").checked ) {
       if( document.getElementById("USD").selected ) {
            document.getElementById("cp1").innerHTML = "00.07 USD";
            document.getElementById("cp2").innerHTML = "01.40 USD";
            document.getElementById("cp3").innerHTML = "07.00 USD";
       } else if( document.getElementById("YEN").selected) {
            document.getElementById("cp1").innerHTML = "007.35 YEN";
            document.getElementById("cp2").innerHTML = "147.00 YEN";
            document.getElementById("cp3").innerHTML = "735.00 YEN";
       } else {
            document.getElementById("cp1").innerHTML = "005.00 INR";
            document.getElementById("cp2").innerHTML = "100.00 INR";
            document.getElementById("cp3").innerHTML = "500.00 INR";
       }
    } else if ( document.getElementById("MotorCycle").checked ) {
        if( document.getElementById("USD").selected ) {
            document.getElementById("mcp1").innerHTML = "00.14 USD";
            document.getElementById("mcp2").innerHTML = "02.80 USD";
            document.getElementById("mcp3").innerHTML = "14.00 USD";
       } else if( document.getElementById("YEN").selected ) {
            document.getElementById("mcp1").innerHTML = "0014.70 YEN";
            document.getElementById("mcp2").innerHTML = "0294.00 YEN";
            document.getElementById("mcp3").innerHTML = "1470.00 YEN";
       } else {
            document.getElementById("mcp1").innerHTML = "0010.00 INR";
            document.getElementById("mcp2").innerHTML = "0200.00 INR";
            document.getElementById("mcp3").innerHTML = "1000.00 INR";
       }
    } else if ( document.getElementById("FourWheelers").checked ) {
        if( document.getElementById("USD").selected ) {
            document.getElementById("fwp1").innerHTML = "00.28 USD";
            document.getElementById("fwp2").innerHTML = "07.00 USD";
            document.getElementById("fwp3").innerHTML = "49.00 USD";
       } else if( document.getElementById("YEN").selected ) {
            document.getElementById("fwp1").innerHTML = "029.40 YEN";
            document.getElementById("fwp2").innerHTML = "735.00 YEN";
            document.getElementById("fwp3").innerHTML = "514.50 YEN";
       } else {
            document.getElementById("fwp1").innerHTML = "0020.00 INR";
            document.getElementById("fwp2").innerHTML = "0500.00 INR";
            document.getElementById("fwp3").innerHTML = "3500.00 INR";
       }
    } 
}  
