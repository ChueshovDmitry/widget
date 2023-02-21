INSERT INTO type_widget ( name, width, height) VALUES
                                                      ('top-left', '100px', '200px'),
                                                      ('top-center', '100px', '200px'),
                                                      ('top-right', '100px', '200px'),
                                                      ('center-left', '100px', '200px'),
                                                      ('center-right', '100px', '200px'),
                                                      ('bottom-left', '100px', '200px'),
                                                      ('bottom-center', '100px', '200px'),
                                                      ('bottom-right', '100px', '200px');


INSERT INTO widget (name, url, action_url, description, default_width, default_height) VALUES
                                                     ('CURRENCY', 'http://auth-service:3010/', 'http://auth-service:3010/currency','Курсы валют из ЦБ', 128, 128),
                                                     ('MESSAGE', 'http://auth-service:3020/', null ,'Tех поддержка', 128, 128);                                               ('MESSAGE', 'http://auth-service:3020/', null,'Tех поддержка', 128, 128);
--                                                      (3, 'statistics_region', 'http://statistics', 'статистика региона', 128, 128, 3),
--                                                      (4, 'exchange_rates ', 'http://exchange_rates', 'курс валют нацбанка', 128, 128, 4),
--                                                      (5, 'ria_news', 'https://ria.ru/', 'новости', 128, 128, 5),
--                                                      (6, 'doc_signature', 'http://doc_signature', 'документы на подпись', 128, 128, 6),
--                                                      (7, 'incoming_mail', 'http://mail', 'входящая почта', 128, 128, 7);
--
-- INSERT INTO user_widget (id, user_id, widget_id, width, height, position_x, position_y, showt,ype_id) VALUES
--                                                     (1, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 1, 125, 125, 22, 44, true),
--                                                     (2, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 2, 130, 130, 22, 44, true),
--                                                     (3, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 3, 130, 130, 22, 44, true),
--                                                     (4, 'd3bc29de-9096-4eee-9fa0-e0267c0faea2', 4, 130, 130, 22, 44, false),
--                                                     (5, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 6, 130, 130, 22, 44, true),
--                                                     (6, 'd3bc29de-9096-4eee-9fa0-e0267c0faea2', 7, 130, 130, 22, 44, true),
--                                                     (7, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 4, 130, 130, 22, 44, true),
--                                                     (8, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 6, 130, 130, 22, 44, false);
