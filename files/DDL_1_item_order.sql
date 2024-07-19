CREATE TABLE if not exists public.orders (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
);

CREATE TABLE if not exists public.items (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
);

-- ===================================================

ALTER TABLE public.items
    ADD COLUMN order_id BIGINT,
    ADD CONSTRAINT fk_item_order
        FOREIGN KEY (order_id) REFERENCES public.orders (id);
