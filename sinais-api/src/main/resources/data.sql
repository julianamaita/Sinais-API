insert into users(id, email, password_hash, full_name, enabled) values
(1, 'demo@sinais.app', '$2a$10$4ByVgEBy4H3Z3nVQYxY4xOZ8xQxVY1qQ4yG8W9S6H5J3k0kQvZ5pK', 'Usuário Demo', true);
-- password of demo user above is 'demo' hashed with BCrypt 10 rounds
insert into user_roles(user_id, role) values (1, 'USER');
