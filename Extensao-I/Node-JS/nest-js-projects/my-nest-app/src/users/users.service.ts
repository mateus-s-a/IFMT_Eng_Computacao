import { Injectable } from '@nestjs/common';

@Injectable()
export class UsersService {
  private readonly users: string[] = ['Spacery', 'Foyer', 'Triz'];
  
  getUsers(): string[] {
    return this.users
  }

  getUsersById(id: number): string {
    return this.users[id]
  }
}
