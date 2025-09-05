import { Injectable } from '@nestjs/common';
import { CreateUserDto } from './dto/create-user.dto';

@Injectable()
export class UsersService {
  private readonly users: string[] = ['Spacery', 'Foyer', 'Triz'];
  
  getUsers(): string[] {
    return this.users;
  }

  getUserById(id: number): string {
    return this.users[id];
  }

  createUser(createUserDto: CreateUserDto): string {
    const newUser = createUserDto.name;
    this.users.push(newUser);
    
    return newUser;
  }
}
