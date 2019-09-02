/*
 * It is a method to validate all the fields of the Registration form
 * @return testing boolean
 */
function validateForm() {
    var r1 = validateFullName();
    var r2 = validateEmail();
    var r3 = validatePassword();
    var r4 = validateConfirmPassword();
    var r5 = validateContact();
    var r6 = validateGender();
    var isValid = (r1 && r2 && r3 && r4 && r5 && r6);
    document.getElementById('isValid').value =isValid;
    return isValid;
}

/*
 * It is a method to validate Full Name label of the Registration Form
 * @return boolean
 */
function validateFullName() {
    var x = document.getElementById("full_name").value;
    var expression = /^[a-zA-Z ]*$/;
    var result = expression.test(x) ;
    if( result === true && document.getElementById("full_name").value.length > 2 ) {
    document.getElementById("full_name_validation").innerHTML="";
     return true;
    } else {
        document.getElementById("full_name_validation").innerHTML="The entered name is not valid";
        return false;
    }
}

/*
 * It is a method to validate Email label of the Registration Form
 * @return boolean
 */
function validateEmail() {
    var x=document.getElementById("email").value;  
    var atposition=x.indexOf("@");  
    var dotposition=x.lastIndexOf(".");  
    if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
        document.getElementById("email_validation").innerHTML="Please enter a valid e-mail address!!";
        return false;
    } else {
    	document.getElementById("email_validation").innerHTML="";
        return true;
    }  
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
    var y = document.getElementById("confirm_password").value;
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

/*
 * It is a method to validate Contact label of the Registration Form
 * @return boolean
 */
function validateContact() {
    var x = document.getElementById("contact").value;
    var expression = /^[0-9]+$/;
    var result = expression.test(x) ;
    if ( result === true  &&  x.length > 8 ) {
    document.getElementById("contact_validation").innerHTML="";
        return true;
    } else {
        document.getElementById("contact_validation").innerHTML="Please enter a valid conact no!!";
        return false;
    } 
}

/*
 * It is a method to validate the required fields of the Vehicle Registration Form
 * @return boolean
 */
function validateVehicleForm() {
    if( document.getElementById("vehicle_name").length !== 0 && document.getElementById("vehicle_number").value.length !== 0 ) {
        return true;
    } else {
        return false;
    }
}

/*
 * It is a method that validates if the gender 
 * field is selected or not
 * 
 */
 function validateGender() {
    var valid = false;
    if( document.getElementById("male").checked || document.getElementById("female").checked ) {
        valid = true;
        document.getElementById("gender_validation").innerHTML = "";
        return valid;
    } else {
        document.getElementById("gender_validation").innerHTML = " Please select a gender!!";
    }
 }
