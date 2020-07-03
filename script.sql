CREATE SEQUENCE public.results_seq;

CREATE TABLE IF NOT EXISTS public.results (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.results_seq'),
  result_date TIMESTAMP(6) NULL DEFAULT NULL,
  result_bet_color VARCHAR(20) NULL DEFAULT NULL,
  result_bet_number INT NULL DEFAULT NULL,
  roulette_id BIGINT NULL DEFAULT NULL,
  round_id BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (id)
 )
;



CREATE SEQUENCE public.roulettes_seq;

CREATE TABLE IF NOT EXISTS public.roulettes (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.roulettes_seq'),
  create_at TIMESTAMP(6) NULL DEFAULT NULL,
  state VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (id))
;



CREATE SEQUENCE public.bets_seq;

CREATE TABLE IF NOT EXISTS public.bets (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.bets_seq'),
  bet_color VARCHAR(255) NULL DEFAULT NULL,
  bet_number INT NULL DEFAULT NULL,
  bet_value DOUBLE PRECISION NULL DEFAULT NULL,
  bet_date TIMESTAMP(6) NULL DEFAULT NULL,
  roulette_id BIGINT NULL DEFAULT NULL,
  round_id BIGINT NULL DEFAULT NULL,
  user_id BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (id))
;




CREATE SEQUENCE public.rounds_seq;

CREATE TABLE IF NOT EXISTS public.rounds (
  id BIGINT NOT NULL DEFAULT NEXTVAL ('public.rounds_seq'),
  create_at TIMESTAMP(6) NULL DEFAULT NULL,
  roulette_id BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (id))

