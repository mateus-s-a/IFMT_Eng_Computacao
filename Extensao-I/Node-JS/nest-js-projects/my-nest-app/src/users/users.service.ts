import { Injectable } from '@nestjs/common';
import { CreateUserDto } from './dto/create-user.dto';
import { UpdateUserDto } from './dto/update-user.dto';

@Injectable()
export class UsersService {
  private readonly users: string[] = ['Spacery', 'Foyer', 'Triz'];
  
  getUsers(): string[] {
    return this.users;
  }

  getUserById(id: number): string {
    return this.users[id];
  }

  /*** CRUD ***/
  createUser(createUserDto: CreateUserDto): string {
    const newUser = createUserDto.name; // get the property name at the DTO
    this.users.push(newUser);
    
    return newUser;
  }

  updateUser(id: number, updateUserDto: UpdateUserDto): string {
    const newName = updateUserDto.name; // property name get
    this.users[id] = newName;

    return `User with id ${id} updated to ${newName}`;
  }

  deleteUser(id: number): string {
    const deletedUser = this.users[id];
    this.users.splice(id, 1);   // remove 1 item at the given index

    return `User "${deletedUser}" with id ${id} has been deleted`;
  }
}
