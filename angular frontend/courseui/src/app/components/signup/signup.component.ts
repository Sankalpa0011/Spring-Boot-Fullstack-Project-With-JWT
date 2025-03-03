import { Component } from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {Signup} from '../../dto/signup';
import {FormsModule} from '@angular/forms';
import {UserService} from '../../service/user.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-signup',
  imports: [
    RouterLink,
    FormsModule
  ],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss'
})
export class SignupComponent {
  signup: Signup = {
    username: "",
    userPassword: "",
    userFirstName: "",
    userLastName: "",
    userRole: "user"
  }

  constructor(private userService: UserService,
              private router: Router,
              private toastr: ToastrService) {
  }
  register() {
    this.userService.registerNewUser(this.signup).subscribe(
      (response) => {
        this.toastr.success("User registered successfully", "success")
        this.router.navigate(['/login'])
        console.log("added success");
      },
      (error) => {
        this.toastr.error("Error registering user", "Error")
        this.router.navigate([''])
        console.log("not success");
      }
    );
  }
}
