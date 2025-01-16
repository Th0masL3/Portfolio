import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:3000/consoles');
  await page.getByRole('link', { name: 'carticon' }).click();
  await page.getByRole('link', { name: 'Logo' }).click();
  await page.getByRole('button', { name: 'Console Icon' }).click();
  await page.getByRole('cell', { name: '67891fce06644f3cf7fcf9c1' }).click();
  await expect(page.getByRole('row', { name: '67891fce06644f3cf7fcf9e7' }).getByRole('button').nth(1)).toBeVisible();
  await page.getByRole('row', { name: '67891fce06644f3cf7fcf9e7' }).getByRole('button').nth(1).click();
  await page.getByRole('link', { name: 'carticon' }).click();
  await expect(page.getByRole('button', { name: 'Remove Item from Cart' })).toBeVisible();
  await page.getByRole('button', { name: 'Remove Item from Cart' }).click();
  await expect(page.getByRole('heading', { name: 'Subtotal: $' })).toBeVisible();
});