/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.inject.rebind.adapter;

import com.google.gwt.inject.client.binder.GinBinder;
import com.google.gwt.inject.client.binder.GinAnnotatedBindingBuilder;
import com.google.gwt.inject.client.binder.GinAnnotatedConstantBindingBuilder;
import com.google.gwt.inject.client.GinModule;
import com.google.inject.Binder;
import com.google.inject.TypeLiteral;

class BinderAdapter implements GinBinder {
  private final Binder binder;

  BinderAdapter(Binder binder) {
    this.binder = binder;
  }

  public <T> GinAnnotatedBindingBuilder<T> bind(Class<T> clazz) {
    return new AnnotatedBindingBuilderAdapter<T>(binder.bind(clazz));
  }

  public <T> GinAnnotatedBindingBuilder<T> bind(TypeLiteral<T> clazz) {
    return new AnnotatedBindingBuilderAdapter<T>(binder.bind(clazz));
  }

  public GinAnnotatedConstantBindingBuilder bindConstant() {
    return new AnnotatedConstantBindingBuilderAdapter(binder.bindConstant());
  }

  public void install(GinModule install) {
    binder.install(new GinModuleAdapter(install));
  }

}
