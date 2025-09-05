import { Injectable } from '@nestjs/common';

@Injectable()
export class UsersService {
  getUsers(): string[] {
    return ['Spacery', 'Foyer', 'Triz']
  }
}
