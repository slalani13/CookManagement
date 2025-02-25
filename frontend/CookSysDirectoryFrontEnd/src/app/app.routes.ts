import { Routes } from '@angular/router';
import { SelectCompanyComponent } from './select-company/select-company.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'select-company', component: SelectCompanyComponent },
    { path: 'home', component: HomeComponent }
];
