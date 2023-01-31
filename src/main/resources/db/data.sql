INSERT INTO type_widget (id, name, width, height) VALUES
                                                      (1, 'weather', 120, 120),
                                                      (2, 'finance', 120, 120),
                                                      (3, 'statistics', 120, 120),
                                                      (4, 'exchange_rates', 120, 120),
                                                      (5, 'news', 120, 120),
                                                      (6, 'documents_status', 120, 120),
                                                      (7, 'mail', 120, 120);

INSERT INTO widget (id, name, url, description, defaul_width, defaul_height, type_id) VALUES
                                                     (1, 'whether_now', 'http://wtether', 'текущая погода', 128, 128, 1),
                                                     (2, 'finance_region', 'http://region', 'финансовая статистика региона', 128, 128, 2),
                                                     (3, 'statistics_region', 'http://statistics', 'статистика региона', 128, 128, 3),
                                                     (4, 'exchange_rates ', 'http://exchange_rates', 'курс валют нацбанка', 128, 128, 4),
                                                     (5, 'ria_news', 'https://ria.ru/', 'новости', 128, 128, 5),
                                                     (6, 'doc_signature', 'http://doc_signature', 'документы на подпись', 128, 128, 6),
                                                     (7, 'incoming_mail', 'http://mail', 'входящая почта', 128, 128, 7);

INSERT INTO user_widget (id, user_id, widget_id, width, height, position_x, position_y, show) VALUES
                                                    (1, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 1, 125, 125, 22, 44, true),
                                                    (2, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 2, 130, 130, 22, 44, true),
                                                    (3, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 3, 130, 130, 22, 44, true),
                                                    (4, 'd3bc29de-9096-4eee-9fa0-e0267c0faea2', 4, 130, 130, 22, 44, false),
                                                    (5, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 6, 130, 130, 22, 44, true),
                                                    (6, 'd3bc29de-9096-4eee-9fa0-e0267c0faea2', 7, 130, 130, 22, 44, true),
                                                    (7, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 4, 130, 130, 22, 44, true),
                                                    (8, '57e8b874-b8e0-4c3d-b2dd-2e50ef11d4c5', 6, 130, 130, 22, 44, false);
