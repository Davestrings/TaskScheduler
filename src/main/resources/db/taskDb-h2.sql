-- CREATE DATABASE IF NOT EXISTS
-- CREATE SCHEMA IF NOT EXIST taskDb


INSERT INTO users(`id`, `username`, `password`,`isActive`, `roles`)
VALUES (1, 'bobby', '', false , 'ROLE_USER'),
(2, 'johnny', '', true , 'ROLE_USER'),
(3, 'tenn', '', true, 'ROLE_USER');

INSERT INTO projects(`id`, `project_name`, `project_code`, `project_manager_id`, `created_at`, `updated_at`)
VALUES (1, 'Task scheduler', 'PCR-182', 2, now(), now()),
(2, 'social media', 'JMB-240', 2, now(), now()),
(3, 'assembly manager', 'AJB-190', 1, now(), now());


INSERT INTO tasks(`id`, `title`, `type`, `description`,`details`, `comments`, `created_at`, `updated_at`,
 `expired_at`, `assignee_user_id`, `project_id`, `status`)
 VALUES (1, 'launch app', 'testing', 'some description text', 'comment from whoever on whatever', now(), now(),
  now(), 1, 2, 'OPEN'),
  (2, 'app management', 'management', 'some description text', 'comment from whoever on whatever', now(), now(),
  now(), 1, 2, 'IN_PROGRESS');


INSERT INTO task_history(`id`, `description`, `task_id`, `comments`, `created_at`, `updated_at`)
  VALUES (1, 'description of the task history', 2, 'comments about the task', now(), now()),
  (2, 'a description of the task history', 1, 'some comments about the task', now(), now());

