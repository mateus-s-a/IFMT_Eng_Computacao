import { Body, Controller, Get, Param, Post, Patch, Delete } from '@nestjs/common';
import { UsersService } from './users.service';
import { CreateUserDto } from './dto/create-user.dto';
import { UpdateUserDto } from './dto/update-user.dto';

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

  @Patch(':id')
  updateUser(@Param('id') id: string, @Body() updateUserDto: UpdateUserDto) {
    return this.usersService.updateUser(parseInt(id, 10), updateUserDto);
  }

  @Delete(':id')
  deleteUser(@Param('id') id: string) {
    return this.usersService.deleteUser(parseInt(id, 10));
  }
}
