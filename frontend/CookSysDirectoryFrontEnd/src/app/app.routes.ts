import { Routes } from '@angular/router';
import { SelectCompanyComponent } from './select-company/select-company.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { TeamComponent } from './team/team.component';
import { ProjectsComponent } from './projects/projects.component';
import { ProjectPageComponent } from './project-page/project-page.component';
import { UsersRegComponent } from './users-reg/users-reg.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'select-company', component: SelectCompanyComponent },
    { path: 'home', component: HomeComponent },
    { path: 'users', component: UsersRegComponent },
    { path: 'team', component: TeamComponent },
    { path: 'projects', component: ProjectsComponent },
    { path: 'project-page', component: ProjectPageComponent },
];
