
export class User {
userId:string;
fullName:string;
username:string;
password:string;
email:string;
role:string;
constructor(userId:string,
    fullName:string,
    username:string,
    password:string,
    email:string,
    role:string){
        this.userId=userId;
this.fullName=fullName;
this.username=username;
this.password =password;
this.email=email;
this.role = role;
    }
    displayInfo(){
        console.log(`user ID: ${this.userId}`);
        console.log(`Full Name: ${this.fullName}`);
        console.log(`Email: ${this.email}`);
    }
}