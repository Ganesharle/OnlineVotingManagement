// src/app/auth/auth.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-auth',
  standalone: true,
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'], // ✅ Correctly placed
  imports: [CommonModule, FormsModule],
})
export class AuthComponent {
  isLoginMode = true;
  email: string = '';
  password: string = '';
  username: string = '';
  message: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit(): void {
    if (this.isLoginMode) {
      this.login();
    } else {
      this.register();
    }
  }

  login(): void {
    this.authService.login(this.username, this.password).subscribe(
      response => {
        this.router.navigate(['/dashboard']);
      },
      error => {
        this.message = 'Login failed';
      }
    );
  }

  register(): void {
    this.authService.register(this.username, this.email, this.password).subscribe(
      response => {
        this.message = 'Registration successful!';
        this.isLoginMode = true;
      },
      error => {
        this.message = 'Registration failed';
      }
    );
  }

  toggleMode(): void {
    this.isLoginMode = !this.isLoginMode;
  }
}
