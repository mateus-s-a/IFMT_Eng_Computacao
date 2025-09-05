import { Body, Controller, Get, Param, Post } from '@nestjs/common';
import { UsersService } from './users.service';
import { CreateUserDto } from './dto/create-user.dto';

@Controller('users')
export class UsersController {
  constructor(private readonly usersService: UsersService) {}

  @Post()
  createUser(@Body() CreateUserDto: CreateUserDto): string {
    return this.usersService.createUser(CreateUserDto);
  }
  
  @Get()
  getUsers(): string[] {
    return this.usersService.getUsers();
  }

  @Get(':id')
  getUserById(@Param('id') id: string): string {
    return this.usersService.getUserById(parseInt(id, 10));
  }
}
