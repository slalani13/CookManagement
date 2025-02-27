import { Routes } from '@angular/router';
import { SelectCompanyComponent } from './select-company/select-company.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { TeamComponent } from './team/team.component';
import { ProjectsComponent } from './projects/projects.component';
import { ProjectPageComponent } from './project-page/project-page.component';
import { UsersRegComponent } from './users-reg/users-reg.component';
import { AuthGuard } from './auth.guard';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'select-company', component: SelectCompanyComponent, canActivate: [AuthGuard] },
    { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'users', component: UsersRegComponent, canActivate: [AuthGuard] },
    { path: 'team', component: TeamComponent, canActivate: [AuthGuard] },
    { path: 'projects', component: ProjectsComponent, canActivate: [AuthGuard] },
    { path: 'project-page', component: ProjectPageComponent, canActivate: [AuthGuard] },
];
