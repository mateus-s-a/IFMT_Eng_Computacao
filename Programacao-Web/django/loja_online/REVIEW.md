## 1. Creating Migrations (Detect Model Changes):
This command scans for your `models.py` files for any changes made to the DataBase models and generates corresponding migration files. These files describe how to update your DataBase schema.

```bash
python manage.py makemigrations
```


## 2. Apply Migrations (Update DataBase Schema):
This command executs the SQL commands defined in your migration files, appling the sche,a changes to the DataBase. Ths will create new tables, modify existing ones, or add/remove columns as specified in the migrations.

```bash
python manage.py migrate
```


## 3. Create Superuser (Administrative User):
This command initiates the process of creating a superuser account, which has full administrative privileges within the Django applications's admin interface. It will be prompted to enter a username, email address, and password for this user.

```bash
python manage.py createsuperuser
```