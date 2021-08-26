INSERT INTO tb_user (name, email, password) VALUES ('Carlos Pedro', 'carlos@email.com', '$2a$12$5Df2RJAEd9KXKfQmiupLGe8DNi0GFM3pH6aHblflBP66b5M3rYE0O');
INSERT INTO tb_user (name, email, password) VALUES ('Joao Marcos', 'joao@email.com', '$2a$12$Zx3FwP7xcxc40IuYhOkjhenfsQMi7elWxAbUt6dYe7Gho2YIoQOu2');
INSERT INTO tb_user (name, email, password) VALUES ('Rogerio Antonio', 'rogerio@email.com', '$2a$12$.XAv/KufuQBpHe/Ei2KXJeCmehNQREXZ5Kn1.Qx2Fns3sqYOg6eIy');
INSERT INTO tb_user (name, email, password) VALUES ('Paulo Augusto', 'paulo@email.com', '$2a$12$Z8YbAIHdZg3QhELPm3ppuOFZ8uEtfDW821s68XcnHmenzGpw.RNyi');
INSERT INTO tb_user (name, email, password) VALUES ('Silvio Roberto', 'silvio@email.com', '$2a$12$ZsRgLwRp51CYBL9Tkkpqqep3Q7UHRM2FMKQJG4a6/m9KeQRweuU2i');
INSERT INTO tb_user (name, email, password) VALUES ('Alan Bruno', 'alan@email.com', '$2a$12$RKEwxc6JjaxYMEe/H7OLietsyZWWUXEBW3ONKgLrCTa3meSympd/i');
INSERT INTO tb_user (name, email, password) VALUES ('Giovani Arnaldo', 'giovani@email.com', '$2a$12$x6XgNf9vZRc3nLjbIySCFujIz1GpATVAAZ07b3GY4/xyG19MZ0Rm.');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (6, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (7, 2);