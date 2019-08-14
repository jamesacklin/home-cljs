(ns demo.subs.core
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
  ::app-view
  (fn [{:keys [page]}]
    {:page-id page}))

(re-frame/reg-sub
  ::twirly
  (fn [{:keys [show-twirly]}]
    show-twirly))

(re-frame/reg-sub
  ::work-expanded
  (fn [{:keys [work-open]}]
    work-open))
