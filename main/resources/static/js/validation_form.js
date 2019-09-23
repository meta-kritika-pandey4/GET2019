/*
 * It is a method to validate all the fields of the Registration form
 * @return testing boolean
 */
function validateForm() {
    var r3 = validatePassword();
    var r4 = validateConfirmPassword();
    var isValid = (r3 && r4);
    window.alert(isValid);
    return isValid;
}

/*
 * It is a method to validate Password label of the Registration Form
 * @return boolean
 */
function validatePassword() {
    var x = document.getElementById("password").value;
    var expression1 = /[a-z]+/;
    var expression2 = /[A-Z]+/;
    var expression3 = /[0-9]+/;
    var expression4 = /[@#%]+/;
    var result = expression1.test(x) && expression2.test(x) && expression3.test(x) && expression4.test(x);
    if ( result === true &&  x.length > 8  ) {
        document.getElementById("password_validation").innerHTML="";
        return true;
    } else {
        document.getElementById("password_validation").innerHTML="Your password should contain atleast one  <br/> Uppercase, Lowercase,  Alphanumeric character and <br/> it  should  have  minimum length <br/> of 8 characters!!!!";
        return false;
    }
}

/*
 * It is a method to validate Confirm Password label of the Registration Form
 * @return boolean
 */
function validateConfirmPassword(){
    var x = document.getElementById("password").value;
    var y = document.getElementById("confirmPassword").value;
    if( y.length === 0 ){
        document.getElementById("confirm_password_validation").innerHTML="The field is empty. Kindly fill it!!!";
    } else if ( x !== y ){
        document.getElementById("confirm_password_validation").innerHTML="Both the passwords do not match!!!";
        return false;
    } else {
    document.getElementById("confirm_password_validation").innerHTML="";
        return true;
    }
}


function validateVehicleForm() {
	 	var r1 = validateVehicleName();
	    var r2 = validateVehicleNumber();
	    var r3 = validateVehicleType();
	    var r4 = validateEmployeeId();
	    var isValid = (r1 && r2 && r3&&r4);
	    if(isValid)
	    {
	    	document.getElementById("signed_vehicle_number").value=document.getElementById("vehicle_number").value;
	    	console.log(document.getElementById("vehicle_number").value);
	    	console.log(document.getElementById("signed_vehicle_number").value);
	    	window.alert(document.getElementById("signed_vehicle_number").value);
	    	document.getElementById("signed_emp_id").value=document.getElementById("employ_id").value;
	    }
	    return isValid;
}

function validateVehicleName(){
	var x = document.getElementById("vehicle_name").value;
    var expression = /^[a-zA-Z ]*$/;
    var result = expression.test(x) ;
    if( result === true && document.getElementById("vehicle_name").value.length > 1 ) {
		document.getElementById("vehicle_name_message").innerHTML="";
		return true;
	} else {
		document.getElementById("vehicle_name_message").innerHTML="Please enter vehicle name";
		return false;
	}
}

function validateVehicleType(){
	if( document.getElementById("Cycle").checked || document.getElementById("MotorCycle").checked ||  document.getElementById("Fourheelers").checked ) {
		document.getElementById("vehicle_type_message").innerHTML="";
		return true;
	} else {
		document.getElementById("vehicle_type_message").innerHTML="Please choose a vehicle type";
		return false
	}
}
function validateVehicleNumber(){
	if( document.getElementById("vehicle_number").value.length === 10 ){
		document.getElementById("vehicle_number_message").innerHTML="";
		return true;
	} else {
		document.getElementById("vehicle_number_message").innerHTML="Please enter vehicle number";
		return false;
	}
}
function validateEmployeeId(){
	if( document.getElementById("employ_id").value >0 ){
		document.getElementById("emp_id_message").innerHTML="";
		return true;
	} else {
		document.getElementById("emp_id_message").innerHTML="Please enter employee id";
		return false;
	}
}
