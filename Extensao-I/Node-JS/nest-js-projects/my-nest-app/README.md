# NestJS Guide



## 1. Setting up NestJS

Installing the NestJS CLI globally on your system:

```bash
npm install -g @nestjs/cli
```

After the installation is complete, we shall create a new NestJS project with:

```bash
nest new my-nest-app
```



## 2. Running up NestJS

To see the app in action, navigate into the project directory and start the development server:

```bash
cd my-nest-app
npm run start:dev
```



## 3. Concepts

- **Modules (`@Module`)**: act as organizers. They group controllers and providers into coherent blocks of functionality. `app.module.ts`

- **Controllers (`@Controller`)**: handle incoming HTTP requests . They delegate the complex logic to services. `app.controller.ts`

- **Services (`@Injectable`)**: handle the business logic and are listed in a module's `providers` array so they can be injected into controllers. `app.service.ts`



---



## 4. Creating new Controllers and Services

A new feature that returns a list of users will need to create a `UsersController` and a `UsersSerivce`.

```bash
nest generate controller users
nest generate service users
```

Adding a method to `UsersController` that returns a simple array of strings:

```ts
// in src/users/users.service.ts
import { Injectable } from '@nestjs/common';


@Injectable()
export class UsersService() {
  getUsers(): string[] {
    return ['Alice', 'Bob', 'Charlie'];
  }
}
```

Injecting the `UsersService` into the `UsersController`:

```ts
// in src/users/users.controller.ts
import { Controller } from '@nestjs/common';
import { UsersService } from './users.service';


@Controller('users')
export class UsersController() {
  constructor(private readonly usersService: usersService) {}
}
```

Creating a `GET` endpoint in the `UsersController` that calls the service method and returns the list of users.

```ts
import { Controller, Get } from '@nestjs/common';
import { UsersService } from './users.service';


@Controller('users')
export class UsersController() {
  constructor(private readonly usersService: usersService) {}

  @Get
  getUsers(): string[] {
    return this.usersService.getUsers();
  }
}
```



## 5. Single User by their ID

To get a single user, it need a dynamic route. Instead of `/users` which always gets the whole list, it will be something like `/users/1` for the user with ID 1, or `/users/2` for the user with ID 2. That `:id` part of the URL s called a **route parameter**.



First, the service. It need a new method in `UsersService` that can find one specific user from the list:

```ts
// in src/users/users.service.ts


import { Injectable } from '@nestjs/common';


@Injectable()
export class UsersService() {
  private readonly users: string[] = ['Alice', 'Bob', 'Charlie'];

  getUsers(): string[] {
    return this.users;
  }
  
  getUsersById(id: number): string {
    return this.users[id];
  }
}
```

Creating the dynamic endpoint:

```ts
// in src/users/users.controller.ts
@Get(':id')
getUserById(@Param('id') id: string): string {
  return this.usersService.getUserById(parseInt(id, 10));
}
```
