import { Controller, Get, Param } from '@nestjs/common';
import { UsersService } from './users.service';

@Controller('users')
export class UsersController {
  constructor(private readonly usersService: UsersService) {}

  @Get()
  getUsers(): string[] {
    return this.usersService.getUsers();
  }

  @Get(':id')
  getUsersById(@Param('id') id: string): string {
    return this.usersService.getUsersById(parseInt(id, 10));
  }
}
