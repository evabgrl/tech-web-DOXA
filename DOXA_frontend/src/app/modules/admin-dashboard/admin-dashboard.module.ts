import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersComponent } from './pages/users/users.component';
import { AdminDashboardRoutingModule } from './admin-dashboard-routing.module';
import { SharedModule } from '../shared/shared.module';
import { PaginatorComponent } from './components/paginator/paginator.component';

@NgModule({
  declarations: [UsersComponent, PaginatorComponent],
  imports: [CommonModule, SharedModule, AdminDashboardRoutingModule],
})
export class AdminDashboardModule {}
