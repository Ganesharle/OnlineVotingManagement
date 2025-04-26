// src/app/auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth'; // ✅ no trailing slash

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    const loginData = { username, password };
    return this.http.post(`${this.apiUrl}/login`, loginData).pipe(
      catchError(this.handleError)
    );
  }

  register(username: string, email: string, password: string): Observable<any> {
    const registerData = { username, email, password };
    return this.http.post(`${this.apiUrl}/register`, registerData).pipe(
      catchError(this.handleError)
    );
  }

  // Get stored JWT token
  getToken(): string | null {
    return localStorage.getItem('token');
  }

  // Check if user is logged in
  isAuthenticated(): boolean {
    return !!this.getToken();
  }

  // Save token to localStorage
  setToken(token: string): void {
    localStorage.setItem('token', token);
  }

  // Remove token from localStorage
  removeToken(): void {
    localStorage.removeItem('token');
  }

  // Optionally create auth headers for secured requests
  getAuthHeaders(): HttpHeaders {
    const token = this.getToken();
    return new HttpHeaders({
      Authorization: `Bearer ${token}`
    });
  }

  // Handle HTTP errors
  private handleError(error: any): Observable<never> {
    console.error('AuthService error:', error);
    return throwError(() => new Error(error.error?.message || 'Server error'));
  }
}
